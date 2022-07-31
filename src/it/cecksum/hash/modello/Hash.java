package it.cecksum.hash.modello;

public class Hash {

    private final String hash1;
    private final String hash2;

    public Hash(String hash1, String hash2) {
        this.hash1 = hash1;
        this.hash2 = hash2;
    }

    public String getHash1() {
        return hash1;
    }

    public String getHash2() {
        return hash2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Primo hash: ").append(this.hash1).append("\n");
        sb.append("Secondo hash: ").append(this.hash2).append("\n");
        return sb.toString().trim();
    }
}
