package com.giaco.test1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Eight houses, represented as cells, are arranged in a straight line.
 * Each day every cell competes with its adjacent cells (neightbors).
 * An integer value of 1 represents an active cell and a value of 0
 * represents an inactive cell. If the neighbors on both the sides of a
 * cell are either active of inactive, the cell becomes inactive on the
 * next day; otherwise the cell becomes active. The two cells on each
 * end have a single adjacent cell, so assume that the unoccupied space
 * on the opposite side is an inactive cell. Even after updating the cell
 * state, consider its previous state when updating the state of ther
 * cells. The state information of all cells should be updated
 * simultaneously.
 * 
 * Write an algorithm to output the state of the cells after the given
 * number of days.
 * 
 * INPUT
 * The input to the function/method consists of two arguments:
 * states, a list of integers representing the current state of cells;
 * days, an integer representing the number of days.
 * 
 * OUPUT
 * Return a list of integers representing the state of the cells after
 * the given number of days.
 * 
 * Note
 * The elements of the list states contains 0s and 1s only.
 * 
 * 
 * @author Giacomo
 *
 */
public class Test100 {

	public static void main(String[] args) {
		int[] input = {1, 1, 1, 0, 1, 1, 1, 1};
		int days = 2;
		List<Integer> output = cellCompete(input, days);
		System.out.println(Arrays.toString(output.toArray()));
	}

    public static List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> result = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        
        for (int i : states) {
        	result.add(i);
        }
        
        for (int dayNumber = 1; dayNumber==days; dayNumber++) {
        	for (int state = 0; state < result.size(); state++) {
        		boolean currentState = false;
        		if (((state == 0 && result.get(1) == 0)
        				|| (state == result.size()-1 && result.get(result.size()-2) == 0))
        				|| ((state > 0 && state < 7) &&
        						(result.get(state-1).equals(result.get(state+1))))) {
        			currentState = true;
        		}

        		if (!currentState) {
        			buffer.add(1);  
        		} else {
        			buffer.add(0);
        		}
        	}
        	result = buffer;
        }

        return result;
    }
	
}
