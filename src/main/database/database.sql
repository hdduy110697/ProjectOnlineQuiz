delimiter //
create TRIGGER before_insert_testID
  before INSERT ON test
  FOR EACH ROW
  begin
  DECLARE counts int;
  select count(*) into counts from test;
  SET new.test_id = concat(lpad(counts+1,3,'0'));
end;//
-- kết thúc trigger