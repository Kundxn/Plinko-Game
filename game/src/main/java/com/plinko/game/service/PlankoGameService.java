package com.plinko.game.service;

import org.springframework.stereotype.Service;

@Service
public class PlankoGameService {

    private static final int NUM_BINS = 9;
    private static final int NUM_PEGS = 15; // Approximate number of pegs per row

    public String playPlinkoGame(int dropPosition) {
        // Simulate the ball drop and bouncing off pegs
        int finalPosition = dropPosition;

        // Simple simulation: The ball bounces randomly, changing its position as it falls
        for (int i = 0; i < NUM_PEGS; i++) {
            finalPosition += (Math.random() > 0.5) ? 1 : -1;
            finalPosition = Math.max(0, Math.min(NUM_BINS - 1, finalPosition)); // Keep ball within bounds
        }

        return "Ball landed in bin " + finalPosition;
    }
}
