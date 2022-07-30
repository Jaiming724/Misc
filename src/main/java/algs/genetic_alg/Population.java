package algs.genetic_alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Population {
    private int generations;
    private final List<DNA> population;
    private int maxFitness = -1;
    private boolean reachedTarget = false;
    private Random random;
    private String best = "";

    public Population(int size) {
        population = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            population.add(new DNA());
        }
        random = new Random();
    }

    public static void main(String[] args) {
        Population population = new Population(100);
        while (!population.isReachedTarget()) {
            population.calcFitness();
            population.mate();
        }
        System.out.println(DNA.mutateOccur);
        System.out.println(DNA.count);
    }

    public void calcFitness() {
        for (DNA dna : population) {
            int fitness = 0;
            for (int j = 0; j < Constants.target.length(); j++) {
                if (dna.getPhenotype().charAt(j) == Constants.target.charAt(j)) {
                    fitness++;
                }
            }
            dna.setFitness(fitness);
            fitness = (int) ((fitness / (double) Constants.target.length()) * 100);
            if (fitness > maxFitness) {
                maxFitness = fitness;
                best = dna.getPhenotype();
            }
            dna.setNormalizedFitness(fitness);
        }
        System.out.println("Best string at generation " + generations + " is " + best);


    }

    public void mate() {
        population.sort(Collections.reverseOrder());

        if (maxFitness > Constants.targetFitness) {
            reachedTarget = true;
            return;
        }
        List<DNA> matingPool = new ArrayList<>();
        for (int i = 0; i < population.size() / 2; i++) {
            for (int j = 0; j < population.get(i).getNormalizedFitness(); j++) {
                matingPool.add(population.get(i));
            }
        }
        for (int i = 0; i < population.size(); i++) {
            DNA parent1 = matingPool.get(random.nextInt(matingPool.size()));
            DNA parent2 = matingPool.get(random.nextInt(matingPool.size()));
            DNA child = parent1.crossOver(parent2);
            child.mutate(Constants.mutationRate);
            population.set(i, child);
        }


        generations++;

    }

    public int getGenerations() {
        return generations;
    }


    public List<DNA> getPopulation() {
        return population;
    }

    public int getMaxFitness() {
        return maxFitness;
    }

    public boolean isReachedTarget() {
        return reachedTarget;
    }
}
