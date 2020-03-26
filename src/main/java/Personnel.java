import java.time.LocalDateTime;

public final class Personnel implements Composite {
    private final String nom;
    private final String prenom;
    private final LocalDateTime naissance;
    private final String telephone;

    private Personnel(Builder builder) {
        //Required
        nom = builder.nom;
        prenom = builder.prenom;

        //Optional
        naissance = builder.naissance;
        telephone = builder.telephone;
    }

    @Override
    public void print() {
        System.out.println("Nom " + this.nom);
    }

    public static class Builder {
        //Required
        private final String nom;
        private final String prenom;

        //Optional
        private LocalDateTime currentTime = LocalDateTime.now();
        private LocalDateTime naissance = currentTime.withDayOfMonth(1).withYear(1990).withMonth(1);
        private String telephone = "+33111111111";

        public Builder(String nom, String prenom) {
            this.nom = nom;
            this.prenom = prenom;
        }

        public Builder naissance(LocalDateTime naissance) {
            this.naissance = naissance;
            return this;
        }

        public Builder telephone(String phone) {
            this.telephone = phone;
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
