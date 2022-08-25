import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BabyNamesPopularityQuery {
    /**
     * Inner class for exception.
     */
    public static class FilePermissionException extends IOException {
        public FilePermissionException(String message, File file) {
            super(message + ": " + file);
        }
    }

    /**
     * Check if the given year parameter is valid.
     *
     * @param year the year
     * @throws YearNotFoundException exception permorfed if it is an invalid year
     */
    private void isValidYear(int year) throws YearNotFoundException {
        if (year < 2001 || year > 2010) {
            throw new YearNotFoundException(year);
        }
    }

    /**
     * Check if the given gender parameter is valid.
     *
     * @param gender the gender
     * @throws GenderNotFoundException exception performed if it is an invalid gender
     */
    private void isValidGender(Character gender) throws GenderNotFoundException {
        if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
            throw new GenderNotFoundException(gender);
        }
    }

    /**
     * Check if the given ranking parameter is valid.
     *
     * @param ranking the ranking number
     * @throws RankingOutOfBoundsException exception performed if it is an invalid ranking
     */
    private void isValidRanking(int ranking) throws RankingOutOfBoundsException {
        if (ranking < 1 || ranking > 1000) {
            throw new RankingOutOfBoundsException(ranking);
        }
    }

    /**
     * Select the name of a given parameters.
     *
     * @param ano the year
     * @param genero the gender
     * @param ranking the ranking number
     * @return the name selected by the parameters
     */
    public String getName(int ano, char genero, int ranking) throws YearNotFoundException, GenderNotFoundException, NameNotFoundException, RankingOutOfBoundsException {
        isValidYear(ano);
        isValidGender(genero);
        isValidRanking(ranking);

        File file = new File("data/babynames/ranking" + ano + ".csv");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file " + file.getName());
            }
            if (!file.canRead()) {
                throw new FilePermissionException("Cannot read file", file);
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                "Check if the file is in the directory. Absolute path: " + file.getAbsolutePath()
            );
            e.printStackTrace();
            System.exit(1);
        } catch (FilePermissionException e) {
            System.err.println("Failed to read the file");
            e.printStackTrace();
            System.exit(1);
        }

        String nameMale = "";
        String nameFemale = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine() && scanner.nextInt() <= ranking) {
                nameMale = scanner.next();
                scanner.nextInt();
                nameFemale = scanner.next();
                scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open the file for reading");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Failed to convert input data");
            e.printStackTrace();
        }

        if (Character.toUpperCase(genero) == 'M') {
            return nameMale;
        }

        return nameFemale;
    }

    /**
     * Select the ranking number of a given parameters.
     *
     * @param ano the year
     * @param genero the gender
     * @param nome the name
     * @return the ranking number selected by the parameters
     *
     * @throws YearNotFoundException exception for invalid year
     * @throws GenderNotFoundException exception for invalid gender
     * @throws NameNotFoundException exception for invalid name
     */
    public int getRanking(int ano, char genero, String nome) throws YearNotFoundException, GenderNotFoundException, NameNotFoundException {
        isValidYear(ano);
        isValidGender(genero);
        
        File file = new File("data/babynames/ranking" + ano + ".csv");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file " + file.getName());
            }
            if (!file.canRead()) {
                throw new FilePermissionException("Cannot read file", file);
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                "Check if the file is in the directory. Absolute path: " + file.getAbsolutePath()
            );
            e.printStackTrace();
            System.exit(1);
        } catch (FilePermissionException e) {
            System.err.println("Failed to read the file");
            e.printStackTrace();
            System.exit(1);
        }

        boolean found = false;
        int rankingNumber = 0;
        
        try (Scanner scanner = new Scanner(file)) {
            String nameMale ;
            String nameFemale;

            while (scanner.hasNextLine() && !found) {
                rankingNumber = scanner.nextInt();
                nameMale = scanner.next();
                scanner.nextInt();
                nameFemale = scanner.next();
                scanner.nextInt();

                if (Character.toUpperCase(genero) == 'M' && nameMale.equals(nome)) {
                    found = true;
                } else if (Character.toUpperCase(genero) == 'F' && nameFemale.equals(nome)) {
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open the file for reading");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Failed to convert input data");
            e.printStackTrace();
        }

        if (!found) {
            throw new NameNotFoundException(nome);
        }

        return rankingNumber;
    }

    /**
     * Select the births quantity of a given parameters.
     * @param ano the year
     * @param genero the gender
     * @param nome the name
     * @return the birhts quantity selected by the parameters
     * @throws YearNotFoundException exception for invalid year
     * @throws GenderNotFoundException exception for invalid gender
     * @throws NameNotFoundException exception for invalid name
     */
    public int getCount(int ano, char genero, String nome) throws YearNotFoundException, GenderNotFoundException, NameNotFoundException {
        isValidYear(ano);
        isValidGender(genero);
        
        File file = new File("data/babynames/ranking" + ano + ".csv");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file " + file.getName());
            }
            if (!file.canRead()) {
                throw new FilePermissionException("Cannot read file", file);
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                "Check if the file is in the directory. Absolute path: " + file.getAbsolutePath()
            );
            e.printStackTrace();
            System.exit(1);
        } catch (FilePermissionException e) {
            System.err.println("Failed to read the file");
            e.printStackTrace();
            System.exit(1);
        }

        boolean found = false;
        int qtyBirths = 0;
        
        try (Scanner scanner = new Scanner(file)) {
            String nameMale ;
            String nameFemale;

            while (scanner.hasNextLine() && !found) {
                scanner.nextInt();
                nameMale = scanner.next();

                if (Character.toUpperCase(genero) =='M') {
                    qtyBirths = scanner.nextInt();
                    nameFemale = scanner.next();
                    scanner.nextInt();
                } else {
                    scanner.nextInt();
                    nameFemale = scanner.next();
                    qtyBirths = scanner.nextInt();
                }
                
                if (Character.toUpperCase(genero) == 'M' && nameMale.equals(nome)) {
                    found = true;
                } else if (Character.toUpperCase(genero) == 'F' && nameFemale.equals(nome)) {
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open the file for reading");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Failed to convert input data");
            e.printStackTrace();
        }

        if (!found) {
            throw new NameNotFoundException(nome);
        }

        return qtyBirths;
    }

    public int getTotal(int ano, char genero) throws YearNotFoundException, GenderNotFoundException {
        isValidYear(ano);
        isValidGender(genero);
        
        File file = new File("data/babynames/ranking" + ano + ".csv");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file " + file.getName());
            }
            if (!file.canRead()) {
                throw new FilePermissionException("Cannot read file", file);
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                "Check if the file is in the directory. Absolute path: " + file.getAbsolutePath()
            );
            e.printStackTrace();
            System.exit(1);
        } catch (FilePermissionException e) {
            System.err.println("Failed to read the file");
            e.printStackTrace();
            System.exit(1);
        }

        int qtyBirths = 0;
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextInt();
                scanner.next();

                if (Character.toUpperCase(genero) =='M') {
                    qtyBirths += scanner.nextInt();
                    scanner.next();
                    scanner.nextInt();
                } else {
                    scanner.nextInt();
                    scanner.next();
                    qtyBirths += scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open the file for reading");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Failed to convert input data");
            e.printStackTrace();
        }

        return qtyBirths;
    }

    public static void main(String[] args) {
        try {
            BabyNamesPopularityQuery bn = new BabyNamesPopularityQuery();
            System.out.println(bn.getTotal(2001, 'm'));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
