CREATE TABLE IF NOT EXISTS school(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
    phone VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS student(
    id SERIAL PRIMARY KEY,
    nui VARCHAR(150) NOT NULL ,
    student_name VARCHAR(255) NOT NULL,
    age VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES school(id)
);

CREATE TABLE IF NOT EXISTS  teacher(
    id SERIAL PRIMARY KEY,
    nui VARCHAR(150) NOT NULL ,
    teacher_name VARCHAR(255) NOT NULL,
    age VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student(id)
);



