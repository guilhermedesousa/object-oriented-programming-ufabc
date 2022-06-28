public class PotentialGeneDetector {
    static boolean isPotentialGene(String dna) {
        // sequence length must be multiple of three
        if (dna.length() % 3 != 0) {
            return false;
        }

        // begins with start codon
        if (!dna.startsWith("ATG")) {
            return false;
        }

        // no intervening stop codons
        for (int i = 3; i < dna.length() - 3; i++) {
            if (i % 3 == 0) {
                String codon = dna.substring(i, i + 3);

                if (codon.endsWith("TAA")) {
                    return false;
                }

                if (codon.endsWith("TAG")) {
                    return false;
                }

                if (codon.endsWith("TGA")) {
                    return false;
                }
            }
        }

        // ends with a stop codon
        if (dna.endsWith("TAA")) {
            return true;
        }

        if (dna.endsWith("TAG")) {
            return true;
        }

        if (dna.endsWith("TGA")) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: PotentialGeneSequencer <sequence>");
        }

        System.out.println(isPotentialGene(args[0]));
    }
}
