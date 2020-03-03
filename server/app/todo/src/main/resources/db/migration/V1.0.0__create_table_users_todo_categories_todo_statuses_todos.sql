CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(256) NOT NULL,
    password CHAR(60) NOT NULL,
    email VARCHAR(256) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE todo_categories(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(256) NOT NULL,
    details varchar(2048) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE todo_statuses(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(256) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE todos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(256) NOT NULL,
    details TEXT NOT NULL,
    due_on TIMESTAMP NOT NULL,
    todo_category_id INT NOT NULL,
    todo_status_id INT NOT NULL,
    user_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (todo_category_id) REFERENCES todo_categories(id),
    FOREIGN KEY (todo_status_id) REFERENCES todo_statuses(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);