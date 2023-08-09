
-- alter table permission modify  perm_id INT(4) AUTO_INCREMENT ;
--select role.*,permission.perm_name from user,role,permission where user.role_id=role.role_id and role.perm_id= permission.perm_id;
select role.*,permission.perm_name from role,permission where role.perm_id= permission.perm_id;
   select role.*,permission.perm_name from role,permission where role.perm_id= permission.perm_id and role_id =${id};


 select distinct user.*,role.role_name 
 from role
  LEFT JOIN user
 ON user.role_id=role.role_id  where username like '%sk_%' or email like '%sk_%' or role_name like '%sk_%' and user.role_id=role.role_id


SELECT DISTINCT c.*,u.univ_name FROM university u RIGHT JOIN course c ON c.univ_id=u.univ_id  WHERE c.course_id=0

ALTER TABLE `semester` ADD `course_id` INT(4) NOT NULL AFTER `sem_id`;
SELECT u.*,r.role_name,p.associate,course_mgmt,user_mgmt,question_mgmt from user u INNER JOIN role r ON u.role_id=r.role_id INNER JOIN permission p ON r.perm_id=p.perm_id