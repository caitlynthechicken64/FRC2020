// Copyright 2019 FRC Team 3476 Code Orange

package frc.utility;

import com.revrobotics.*;

/**
 * Sends only new commands to the Talon to reduce CAN usage.
 */
public class LazyCANSparkMax extends CANSparkMax {
	
	private double prevValue = 0;

	public LazyCANSparkMax(int deviceNumber, MotorType type, double nominalVoltage) {
		super(deviceNumber, type);
		enableVoltageCompensation(nominalVoltage);
	}
	
	public LazyCANSparkMax(int deviceNumber, MotorType type) {
		super(deviceNumber, type);
		enableVoltageCompensation(12);
	}

	@Override
	public void set(double outputValue) {
		//return;
			
		if (outputValue != prevValue) {
			super.set(outputValue);
			prevValue = outputValue;
		}
	
	}

	public double getSetpoint() {
		return prevValue;
	}
}
