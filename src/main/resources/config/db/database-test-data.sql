--
-- Copyright 2010-2019 the original author or authors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--    http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

insert into t_user
VALUES ('u1', 'Pocoyo');
insert into t_user
VALUES ('u2', 'Pato');
insert into t_user
VALUES ('u3', 'Eli');
insert into t_user
VALUES ('u4', 'Valentina');
insert into t_user
VALUES ('u5', 'Taro Yamada');
insert into t_user
VALUES ('test1', 'test1');

insert into persons (person_id, first_name, last_name)
VALUES (1, 'test1', 'test1');
insert into persons (person_id, first_name, last_name)
VALUES (2, 'test2', 'test1');
insert into persons (person_id, first_name, last_name)
VALUES (3, 'test3', 'test1');
