class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder alphabets = new StringBuilder("A");
        for (char alp = 'B'; alp <= 'Z'; alp++) {
            alphabets.append(" ").append(alp);
        }

        return alphabets;
    }
}