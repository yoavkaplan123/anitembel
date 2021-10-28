// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.kauailabs.navx.frc.AHRS;
//import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  /** Creates a new beasSubsystem. */

  private static CANSparkMax leftF;
  private static CANSparkMax leftB;
  private static CANSparkMax rightF;
  private static CANSparkMax rightB;

  private static Chassis Chassis;

  // private AHRS nevx;

  // private CANEncoder encoderLeftF;
  // private CANEncoder encoderRightF;


  public Chassis() {
    leftF = new CANSparkMax(Constants.leftFID, MotorType.kBrushless);
    leftB = new CANSparkMax(Constants.leftBID, MotorType.kBrushless);
    rightF = new CANSparkMax(Constants.rightFID, MotorType.kBrushless);
    rightB = new CANSparkMax(Constants.rightBID, MotorType.kBrushless);

    leftF.setIdleMode(IdleMode.kBrake);
    leftB.setIdleMode(IdleMode.kBrake);
    rightF.setIdleMode(IdleMode.kBrake);
    rightB.setIdleMode(IdleMode.kBrake);

    leftB.follow(leftF);
    rightB.follow(rightF);

    // nevx = new AHRS();

    // encoderLeftF = leftF.getEncoder();
    // encoderLeftF.setPositionConversionFactor(Constants.leftFID);
    // encoderLeftF.setVelocityConversionFactor(Constants.leftFID);
    
    // encoderRightF = rightF.getEncoder();
    // encoderRightF.setPositionConversionFactor(Constants.rightFID);
    // encoderRightF.setVelocityConversionFactor(Constants.rightFID);

  }

  public static void set (double leftPower, double rightPower){
    leftF.set(leftPower);
    rightF.set(rightPower);
  }

  public static Chassis getinstance(){
    if (Chassis == null){
      Chassis = new Chassis();
    }
    return Chassis;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
