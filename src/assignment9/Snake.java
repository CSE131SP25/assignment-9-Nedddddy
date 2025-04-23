package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.0;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		for (int i = segments.size()-1; i>0; i--) {
			BodySegment current = segments.get(i);
			BodySegment previous = segments.get(i - 1);
			current.setX(previous.getX());
			current.setY(previous.getY());
		}
		
		BodySegment head = segments.get(0);
		head.setX(head.getX()+ deltaX);
		head.setY(head.getY()+ deltaY);
		
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for(BodySegment s:segments) {
			s.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.get(0);
		double dx = head.getX() - f.getX();
		double dy = head.getY() - f.getY();
		double distance = Math.sqrt(dx*dx + dy*dy);
		
		if(distance < f.FOOD_SIZE + SEGMENT_SIZE) {
			BodySegment tail = segments.get(segments.size() - 1);
			segments.add(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE));
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.get(0);
		if(head.getX()-SEGMENT_SIZE >= 0 && head.getX() + SEGMENT_SIZE <= 1 && head.getY()-SEGMENT_SIZE >= 0 && head.getY() + SEGMENT_SIZE<=1) {
			return true;
		}
		return false;
	}
}
