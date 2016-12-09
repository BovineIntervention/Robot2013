

package edu.wpi.first.wpilibj.templates;


//import edu.wpi.first.wpilibj.camera.AxisCamera;
//import edu.wpi.first.wpilibj.image.ColorImage;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import javax.microedition.midlet.MIDletStateChangeException;
import edu.wpi.first.wpilibj.buttons.Button;


public class RobotTemplate extends SimpleRobot {
    
    
    
    //Ultrasonic swagSonic = new Ultrasonic(1,2,3,4);  
  //  Servo swervo = new Servo(8);ii
    AxisCamera cam;
    Jaguar j1  = new Jaguar(1); //back left   racheal
    Jaguar j2 = new Jaguar(2); //front right  ryan
    Jaguar j3 = new Jaguar(3); //front left   rakul
    Jaguar j4 = new Jaguar(4); //back right   rex
    Jaguar j5 = new Jaguar(5);  //bottom shooting wheels albert   
    Jaguar j6 = new Jaguar(6);  //loading arm     ralph
    Jaguar hook = new Jaguar(7);  //loading arm     ral
    Joystick leftStick = new Joystick(1); // joystick1
    Joystick rightStick = new Joystick(2);
    Object swagject = new Object();
    //Gyro superawsomegyro = new Gyro(1);
    Solenoid snoid1 = new Solenoid(1);
    Solenoid snoid2 = new Solenoid(2);
    Solenoid snoid3 = new Solenoid(3);
    Solenoid snoid4 = new Solenoid(4);
    Solenoid snoid5 = new Solenoid(5);
    Solenoid snoid6 = new Solenoid(6);
    Solenoid snoid7 = new Solenoid(7);
    Solenoid snoid8 = new Solenoid(8);
    RobotDrive drive = new RobotDrive(j1,j2,j3,j4);
    Relay s = new Relay(2);
    
    Timer time2 = new Timer();
    Compressor comp = new Compressor(2,1);
    ColorImage image;
     
    
    public void autonomous() {  //no longer works (shootshoot is now a solenoid (snoid7 and snoid8) - needs to be fixed)
        Timer time = new Timer();
        time.start();
        time.reset();
        
        
        comp.start();
        
        while(time.get() < 15) {                          
            snoid1.set(true);
            snoid6.set(false);
            snoid7.set(true);
            snoid8.set(false);
            j6.set(.7);
            time2.delay(1.3);
            j6.set(1);
            time2.delay(5);
                      
                        snoid7.set(false);
                        snoid8.set(true);
                        
                        
                        
                        time2.delay(1);
                
                        
                        snoid7.set(true);
                        snoid8.set(false);
                        
                        time2.delay(.2);
                        snoid1.set(false);
                        snoid6.set(true);
                        
                        time2.delay(.5);
                        snoid1.set(true);
                        snoid6.set(false);
                        
                        time2.delay(1);
                     
                     for(int i = 0; i < 3; i++)
                     {
                        snoid7.set(false);
                        snoid8.set(true);
                
                        time2.delay(1);
                
                        snoid7.set(true);
                        snoid8.set(false);
                        time2.delay(.2);
                        snoid1.set(false);
                        snoid6.set(true);
                        
                        time2.delay(.5);
                        snoid1.set(true);
                        snoid6.set(false);
                        
                        
                        time2.delay(.7);
                     }
        }
        
        
        time.stop();
    
    }

   
    public void operatorControl() {
        int count2 = 0;
        time2.reset();
        j1.set(0);
        this.j2.set(0<1?0:0);           //ternary operators ftw
        j3.set(0);
        j4.set(0);
        j5.set(0);
        this.j6.set(0);
        hook.set(0);
        CriteriaCollection cc = new CriteriaCollection();
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 0, 55, true);
        snoid1.set(false);
        snoid2.set(false);
        snoid3.set(false);
        snoid4.set(false);
        snoid5.set(false);
        //comp.start();
       snoid6.set(false);
       snoid7.set(false);
       snoid8.set(false);
       Timer tLeft = new Timer();
       String timeString;
       tLeft.start();
       
       s.set(Relay.Value.kForward);
       Timer.delay(1);
       s.set(Relay.Value.kReverse);
       Timer.delay(1);
       s.set(Relay.Value.kOff);
       Timer.delay(1);
       
       tLeft.reset();
       int mins;
       int sec = 0;
       DriverStationLCD j =  DriverStationLCD.getInstance();
            while (true && isOperatorControl() && isEnabled()) { // loop until change
                
                
               /* sec = (int)(120 - tLeft.get());
                mins = sec/60;
                timeString =  mins + ":" + Integer.toString(sec - (mins * 60));
                
                j.println(DriverStationLCD.Line.kUser1, 1, timeString);*/
                if (leftStick.getRawButton(7)) {
                    
                    
                    if (count2 == 0) {
                 j6.set(.7);
                 count2 = 1;
                 time2.delay(1.3);
                      }
                      
                      j6.set(.9);
                    
                }else if (leftStick.getRawButton(11)) {
                    
                    if (count2 == 0) {
                 j6.set(.7);
                 count2 = 1;
                 time2.delay(1.3);
                      }
                      
                      j6.set(.8);
                    
                } else if (leftStick.getRawAxis(3) > .9) {
                    
                       if (count2 == 0) {
                 j6.set(.7);
                 count2 = 1;
                 time2.delay(1.3);
                      }
                      
                      j6.set(.7);  
                    
                    
                }
                
                
                
                
                if (rightStick.getRawButton(3)) {
                snoid4.set(false);
        snoid5.set(true);
       // System.out.println("yes");
                } else if (rightStick.getRawButton(2)) {
                snoid4.set(true);
        snoid5.set(false);
     //   System.out.println("no");
                }
                
                if (rightStick.getRawButton(6)) {
                    
                    snoid6.set(true);
                    snoid1.set(false);
                    
                } else if (rightStick.getRawButton(7)) {
                    
                    snoid6.set(false);
                    snoid1.set(true);
                    
                    
                }
                
                if (leftStick.getRawButton(3)) {
                    
                    snoid2.set(true);
                    snoid3.set(false);
                    
                    
                } else {
                    
                    snoid2.set(false);
                    snoid3.set(true);
                    
                    
                }
               
                if (leftStick.getRawAxis(6) > .5 || leftStick.getRawAxis(7) > .5) {
                    
                    snoid6.set(true);
                    snoid1.set(false);
                    
                    
                } else if (leftStick.getRawAxis(6) < -.5 || leftStick.getRawAxis(7) < -.5) {
                    
                snoid6.set(false);
                    snoid1.set(true);    
                    
                }
                
                
                hook.set(rightStick.getY()>.05||rightStick.getY()/3<-.05?rightStick.getY()/3:0);
                
   j.updateLCD();
                
                time2.reset();                 
                
                
                  drive.mecanumDrive_Cartesian(-leftStick.getRawAxis(3), leftStick.getRawAxis(1), -leftStick.getRawAxis(2), 0);
                  
                  //if (leftStick.getRawButton(1)) {
                      
                    //  j6.set(1);
                      
                 // } else if (!leftStick.getRawButton(1) && count2 == 1) {
                //      j6.set(0);
                 // }
                  
                  if (leftStick.getRawButton(4)) {
                
                      if (count2 == 0) {
                 j6.set(.7);
                 count2 = 1;
                 time2.delay(1.3);
                      }
                      
                      j6.set(1);
                             
                
            }    else if (leftStick.getRawButton(2)) {
                
                j6.set(0);
                count2 = 0;
            }
            
            if(leftStick.getRawButton(1))  {
                snoid7.set(false);
                snoid8.set(true);
               
            } else {
                snoid7.set(true);
                snoid8.set(false);
            }
                  
            
            if (rightStick.getRawButton(4)) {
                
                j5.set(1);
                
                
            } else if (rightStick.getRawButton(5)) {
                
                j5.set(-1);
                
                
            } else {
                
                j5.set(0);
                
            }
                  
                  
               }
         }
    }