// Student class
class Student {
    private Integer id;
    private String name;
    private String course;
    private Double marks;

    // Constructor
    public Student(Integer id, String name, String course, Double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    // Display Student Details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course + ", Marks: " + marks;
    }
}