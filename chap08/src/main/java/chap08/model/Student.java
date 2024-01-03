package chap08.model;

public class Student {
	
	private String stu_id;
	private String stu_name;
	private Integer stu_age;
	private Integer stu_kor;
	private Integer stu_eng;
	private Integer stu_math;
	
	public Student() {
		
	}
	
	public Student(String stu_id, String stu_name, Integer stu_age, Integer stu_kor, Integer stu_eng,
			Integer stu_math) {
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_age = stu_age;
		this.stu_kor = stu_kor;
		this.stu_eng = stu_eng;
		this.stu_math = stu_math;
	}
	
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Integer getStu_age() {
		return stu_age;
	}
	public void setStu_age(Integer stu_age) {
		this.stu_age = stu_age;
	}
	public Integer getStu_kor() {
		return stu_kor;
	}
	public void setStu_kor(Integer stu_kor) {
		this.stu_kor = stu_kor;
	}
	public Integer getStu_eng() {
		return stu_eng;
	}
	public void setStu_eng(Integer stu_eng) {
		this.stu_eng = stu_eng;
	}
	public Integer getStu_math() {
		return stu_math;
	}
	public void setStu_math(Integer stu_math) {
		this.stu_math = stu_math;
	}
	
	public Double getAvg() {
		return (stu_kor + stu_eng + stu_math) / 3.0;
	}
	
	@Override
	public String toString() {
		return String.format("[%s/%s/%d/%d/%d/%d]",
				stu_id, stu_name, stu_age, stu_kor, stu_eng, stu_math);
	}
	
}
