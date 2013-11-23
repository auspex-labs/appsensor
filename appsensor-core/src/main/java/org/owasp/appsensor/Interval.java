package org.owasp.appsensor;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import org.eclipse.persistence.oxm.annotations.XmlPath;

/**
 * The Interval represents a span of time. The key components are the: 
 * 
 * <ul>
 * 		<li>duration (example: 15)</li>
 * 		<li>unit: (example: minutes)</li>
 * </ul>
 * 
 * @see java.io.Serializable
 *
 * @author John Melton (jtmelton@gmail.com) http://www.jtmelton.com/
 */
public class Interval implements Serializable {

	private static final long serialVersionUID = -5187503848358707060L;
	
	public static final String SECONDS = "seconds";
	public static final String MINUTES = "minutes";
	public static final String HOURS = "hours";
	public static final String DAYS = "days";
	
	@XmlPath("text()")
	private int duration;
	
	@XmlAttribute
	private String unit;

	public Interval() {}
	
	public Interval(int duration, String unit) {
		setDuration(duration);
		setUnit(unit);
	}
	
	public int getDuration() {
		return duration;
	}

	public Interval setDuration(int duration) {
		this.duration = duration;
		return this;
	}
	
	public String getUnit() {
		return unit;
	}

	public Interval setUnit(String unit) {
		this.unit = unit;
		return this;
	}
	
	public long toMillis() {
		long millis = 0;
		
		if (SECONDS.equals(getUnit())) {
			millis = 1000 * getDuration();
		} else if (MINUTES.equals(getUnit())) {
			millis = 1000 * 60 * getDuration();
		} else if (HOURS.equals(getUnit())) {
			millis = 1000 * 60 * 60 * getDuration();
		} else if (DAYS.equals(getUnit())) {
			millis = 1000 * 60 * 60 * 24 * getDuration();
		} 
		
		return millis;
	}
	
}
