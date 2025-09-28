
-- 删除旧数据库
DROP DATABASE IF EXISTS company;

-- 创建新数据库
CREATE DATABASE company;

-- 使用新建的数据库
USE company;

-- 创建员工表
CREATE TABLE EMPLOYEE (
                          id INT NOT NULL AUTO_INCREMENT,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(50) NOT NULL,
                          salary DECIMAL(10, 2) NOT NULL,
                          PRIMARY KEY (id)
);

-- 插入一些示例数据
INSERT INTO EMPLOYEE (first_name, last_name, email, salary) VALUES
                                                                ('John', 'Doe', 'johndoe@somemail.com', 1000.00),
                                                                ('Mary', 'Smith', 'msmith@goodmail.com', 2000.00),
                                                                ('Peter', 'Jones', 'peterjones@greatmail.com', 3000.00);
-- 授权新用户访问 company 库
GRANT ALL PRIVILEGES ON company.* TO 'hechun'@'localhost';

-- 刷新权限
FLUSH PRIVILEGES;
SELECT * FROM company.employee;
SELECT User, Host FROM mysql.user;
SELECT USER();
SELECT CURRENT_USER();
ALTER USER 'hechun'@'localhost' IDENTIFIED BY '123456';
FLUSH PRIVILEGES;






