import java.time.LocalDateTime;

public final class Personnel implements Composite {
    private final String Nom;
    private final String Prenom;
    private final LocalDateTime Naissance;
    private final String Telephone;

    private Personnel(Builder builder) {
        //Required
        Nom = builder.Nom;
        Prenom = builder.Prenom;

        //Optional
        Naissance = builder.Naissance;
        Telephone = builder.Telephone;
    }

    @Override
    public void print() {
        System.out.println("Nom " + this.Nom);
    }

    public static class Builder {
        //Required
        private final String Nom;
        private final String Prenom;

        //Optional
        private LocalDateTime currentTime = LocalDateTime.now();
        private LocalDateTime Naissance = currentTime.withDayOfMonth(1).withYear(1990).withMonth(1);
        private String Telephone = "+33111111111";

        public Builder(String Nom, String Prenom) {
            this.Nom = Nom;
            this.Prenom = Prenom;
        }

        public Builder Naissance(LocalDateTime naissance) {
            Naissance = naissance;
            return this;
        }

        public Builder Telephone(String phone) {
            this.Telephone = phone;
            return this;
        }

        public Personnel build() {
            return new Personnel(this);
        }

    }

 /*   public static void main(String[] args) {
        Personnel p1 = new Personnel
                .Builder("P1", "P1")
                .build();

    }
 */
}
