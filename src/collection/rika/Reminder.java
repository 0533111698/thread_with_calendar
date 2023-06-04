package collection.rika;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

    public class Reminder implements Comparable<Reminder> {

        private LocalDateTime expiration;
        private String text;
        private boolean important;
        private boolean popped = false;

        public Reminder(LocalDateTime expiration, String text) {
            super();
            this.expiration = expiration;
            this.text = text;
            this.setImportant(important);
            this.popped = popped;
        }

        public LocalDateTime getExpiration() {
            return expiration;
        }

        public void setExpiration(LocalDateTime expiration) {
            this.expiration = expiration;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean isImportant() {
            return important;
        }

        public void setImportant(boolean important) {
            Scanner s = new Scanner(System.in);
            System.out.println("insert V if the reminder is important, otherwise enter N");
            String special = s.nextLine();
            if (special.equals("V")) {
                this.important = true;
            } else if (special.equals("N")) {
                this.important = false;
            } else {
                System.out.println("error");
                setImportant(important);
            }
        }

        public boolean isPopped() {
            return popped;
        }

        public void setPopped(boolean popped) {
            this.popped = popped;
        }

        @Override
        public int compareTo(Reminder o) {
            return (this.expiration.compareTo(o.expiration));
        }

        @Override
        public int hashCode() {
            return Objects.hash(expiration, text);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Reminder other = (Reminder) obj;
            return Objects.equals(expiration, other.expiration) && Objects.equals(text, other.text);
        }

        @Override
        public String toString() {
            return "Reminder [expiration- " + expiration + ", text= " + text + ", Is he important- " + important
                    + ", Did the task popped- " + popped + "]";
        }

    }


