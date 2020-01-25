// Copyright 2019 FRC Team 3476 Code Orange

package frc.utility;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/**
 * Sends only new commands to the Talon to reduce CAN usage.
 */
public class LazyTalonFX extends TalonFX {
	
	private double prevValue = 0;
	private ControlMode prevControlMode = ControlMode.Disabled;

	public LazyTalonFX(int deviceNumber) {
		super(deviceNumber);
		enableVoltageCompensation(true);
		configVoltageCompSaturation(12, 10);
	}

	@Override
	public void set(ControlMode controlMode, double outputValue) {
		//return;
		
		if (outputValue != prevValue || controlMode != prevControlMode) {
			super.set(controlMode, outputValue);
			prevValue = outputValue;
		} 
	}

	public double getSetpoint() {
		return prevValue;
	}
}
