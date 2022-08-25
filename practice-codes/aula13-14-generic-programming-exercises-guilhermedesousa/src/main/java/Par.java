/**
 * Class that represents a sorted pair with key-value.
 */
public final class Par<T, S> {
    private final T chave;
    private final S valor;

    /**
     * Create an instance of Par.
     *
     * @param chave the key
     * @param valor the value
     */
    public Par(T chave, S valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public T getChave() {
        return this.chave;
    }

    public S getValor() {
        return this.valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Par)) {
            return false;
        }

        Par<T, S> par = (Par<T, S>) o;

        if (!this.getChave().equals(par.getChave())) {
            return false;
        }

        return this.getValor().equals(par.getValor());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chave == null) ? 0 : chave.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }
}
