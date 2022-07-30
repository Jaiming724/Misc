package algs.genetic_alg;

import java.util.Random;

public class DNA implements Comparable<DNA> {
    private char[] gene;
    private int normalizedFitness;
    private int fitness;
    private Random random = new Random();
    public static int mutateOccur = 0;
    public static int count = 0;

    public DNA() {
        int size = Constants.target.length();
        this.gene = new char[size];

        for (int i = 0; i < size; i++) {
            int x = random.nextInt(26) + 97;
            this.gene[i] = (char) x;
        }
    }


    public DNA crossOver(DNA parent2) {

        DNA child = new DNA();
        for (int i = 0; i < Constants.target.length(); i++) {
            int num = random.nextInt(2);
            if (num == 0) {
                child.getGene()[i] = this.gene[i];
            } else {
                child.getGene()[i] = parent2.getGene()[i];
            }
        }
        return child;
    }

    public void mutate(int chance) {
        count++;
        for (int i = 0; i < gene.length; i++) {
            int num = random.nextInt(100);
            if (num < chance) {
                int x = random.nextInt(26) + 97;
                mutateOccur++;
                gene[i] = (char) x;
            }
        }
    }

    public String getPhenotype() {
        return String.valueOf(gene);
    }

    public int getNormalizedFitness() {
        return normalizedFitness;
    }

    public void setNormalizedFitness(int normalizedFitness) {
        this.normalizedFitness = normalizedFitness;
    }

    public char[] getGene() {
        return gene;
    }

    public void setGene(char[] gene) {
        this.gene = gene;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public int compareTo(DNA o) {
        return Integer.compare(normalizedFitness, o.normalizedFitness);
    }
}
