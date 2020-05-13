package main.util;

import main.service.Action;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * 调度器
 */
public class Schedule {
    private int currentTime;
    private LinkedList<Segment> segments;

    public Schedule() {
        currentTime = 0;
        segments = new LinkedList<>();
    }

    Integer getCurrentTime() {
        return currentTime;
    }

    Action firstAction() {
        if(!isEmpty()) {
            this.currentTime = segments.getFirst().time;
            return segments.getFirst().actions.peek();
        }
        return null;
    }

    void removeFirstAction() {
        if(isEmpty()) {
            return;
        }
        Queue<Action> actions = segments.getFirst().actions;
        actions.poll();
        if(actions.isEmpty()) {
            segments.pop();
        }
    }

    void addAction(int time, Action action) {
        Segment new_segment = makeSegment(time, action);
        if(isEmpty()) {
            segments.add(new_segment);
            return;
        }
        ListIterator<Segment> listIter = segments.listIterator();
        while ((listIter.hasNext())) {
            Segment segment = listIter.next();
            if(time == segment.time) {
                segment.actions.add(action);
                return;
            }
            else if(time < segment.time) {
                if(listIter.hasPrevious()) {
                    listIter.previous();
                    listIter.add(new_segment);
                }
                else {
                    segments.addFirst(new_segment);
                }
                return;
            }
        }
        segments.addLast(new_segment);
    }

    Segment makeSegment(int time, Action action) {
        Queue<Action> actions = new ArrayDeque<>();
        actions.add(action);
        return new Segment(time, actions);
    }

    boolean isEmpty() {
        return segments.isEmpty();
    }
    private static class Segment {
        int time;
        Queue<Action> actions;

        public Segment(int time, Queue<Action> actions) {
            this.time = time;
            this.actions = actions;
        }
    }

    public static void propogate(Schedule schedule) {
        while(!schedule.isEmpty()) {
            schedule.firstAction().action();
            schedule.removeFirstAction();
        }
    }

    public static void afterDelay(Schedule schedule, int delay, Action action) {
        schedule.addAction(delay + schedule.getCurrentTime(), action);
    }
}
