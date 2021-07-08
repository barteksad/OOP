package pracownicy;

interface Terminal<T> {
    /** wysyła przesyłkę do terminala o podanym adresie */
    void wyślij(int adres, T przesyłka);

    /** czeka na przesyłkę i odbiera ją */
    T czekajOdbierz();
}
