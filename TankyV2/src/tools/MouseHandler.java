//package tools;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
//
///**
// * 3/15/2022 - 9:17 AM
// *
// * @author simon
// */
//
//public class MouseHandler implements MouseMotionListener {
//
//    private double angleM;
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        this.angleM = (Math.toDegrees(Math.atan2(e.getY(), e.getX()))) % 360;
//    }
//
//    public double getAngleM() {
//        return this.angleM;
//    }
//}
