package com.example.ecomm.models;

public class Components {


        private String name;
        private int image;

        public Components(String name, int image) {
            this.name = name;
            this.image = image;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }



