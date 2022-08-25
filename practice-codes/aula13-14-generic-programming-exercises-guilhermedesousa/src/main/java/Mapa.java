import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a collection of key-value pairs.
 */
public class Mapa<T, S> {
    private List<Par<T, S>> mapa = new ArrayList<>();

    /**
     * Get the value of a given key.
     *
     * @param chave the key
     * @return the value liked with the key
     * @throws ElementoNaoEncontradoException exception in case a nonexistent key
     */
    public S recuperar(T chave) throws ElementoNaoEncontradoException {
        if (!contemChave(chave)) {
            throw new ElementoNaoEncontradoException("Cannot find the given key: " + chave);
        }

        return valores().get(chaves().indexOf(chave));
    }

    /**
     * Insert a pair in the map.
     *
     * @param chave the key
     * @param valor the value
     * @throws ElementoJaExisteException exception in case an existent key
     */
    public void inserir(T chave, S valor) throws ElementoJaExisteException {
        if (contemChave(chave)) {
            throw new ElementoJaExisteException("The given key already exists: " + chave);
        }

        this.mapa.add(new Par<>(chave, valor));
    }

    /**
     * Remove a pair in the map.
     *
     * @param chave the key
     * @throws ElementoNaoEncontradoException exception in case a nonexistent key
     */
    public void remover(T chave) throws ElementoNaoEncontradoException {
        if (!contemChave(chave)) {
            throw new ElementoNaoEncontradoException("Cannot find the given key: " + chave);
        }

        mapa.remove(getPair(chave));
    }

    /**
     * Substitute a value of a pair in the map.
     *
     * @param chave the key
     * @param valor the new value
     * @throws ElementoNaoEncontradoException exception in case a nonexistent key
     */
    public void substituir(T chave, S valor) throws ElementoNaoEncontradoException {
        if (!contemChave(chave)) {
            throw new ElementoNaoEncontradoException("Cannot find the given key: " + chave);
        }

        this.remover(chave);
        this.mapa.add(new Par<>(chave, valor));
    }

    /**
     * Get a pair in the map through a given key.
     *
     * @param chave the key
     * @return the pair associated
     */
    private Par<T, S> getPair(T chave) {
        int i = 0;

        while (!this.mapa.get(i).getChave().equals(chave)) {
            i++;
        }

        return this.mapa.get(i);
    }

    /**
     * Check if exists a given key in the map.
     *
     * @param chave the key
     * @return true if exists, false otherwise
     */
    public boolean contemChave(T chave) {
        return chaves().contains(chave);
    }

    /**
     * Check if exists a given value in the map.
     *
     * @param valor the value
     * @return true if exists, false otherwise
     */
    public boolean contemValor(S valor) {
        return valores().contains(valor);
    }

    /**
     * Get the map size.
     *
     * @return the size
     */
    public int tamanho() {
        return this.mapa.size();
    }

    /**
     * Get all the keys stored by the map.
     *
     * @return an array list of keys
     */
    public List<T> chaves() {
        ArrayList<T> chaves = new ArrayList<>();

        for (Par<T, S> par : this.mapa) {
            chaves.add(par.getChave());
        }

        return chaves;
    }

    /**
     * Get all the values stored by the map.
     *
     * @return an array list of value
     */
    public List<S> valores() {
        ArrayList<S> valores = new ArrayList<>();

        for (Par<T, S> par : this.mapa) {
            valores.add(par.getValor());
        }

        return valores;
    }
}
