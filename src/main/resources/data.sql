insert into Ingredient (id, name, type)
values ('DFWR', 'Обычный лаваш', 'WRAP');
insert into Ingredient (id, name, type)
values ('CHWR', 'Сырный лаваш', 'WRAP');
insert into Ingredient (id, name, type)
values ('CHKN', 'Курица', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('LAMB', 'Баранина', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('LLKB', 'Люля Кебаб', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('HLPN', 'Халапеньо', 'SUPPLEMENT');
insert into Ingredient (id, name, type)
values ('CHES', 'Сыр', 'SUPPLEMENT');
insert into Ingredient (id, name, type)
values ('PTAT', 'Картошка фри', 'SUPPLEMENT');
insert into Ingredient (id, name, type)
values ('SALD', 'Летний салат', 'SUPPLEMENT');
insert into Ingredient (id, name, type)
values ('BTSC', 'Биг Тейсти соус', 'SAUCE');
insert into Ingredient (id, name, type)
values ('BMSC', 'Биг Мак соус', 'SAUCE');

-- Добавление записей в таблицу DONER
INSERT INTO DONER (ID, NAME, MEAT_ID, WRAP_ID, CREATED_AT) VALUES
                                                               (1, 'Классический с бараниной', 'LAMB', 'DFWR', CURRENT_TIMESTAMP),
                                                               (2, 'Сырный с курицей', 'CHKN', 'CHWR', CURRENT_TIMESTAMP),
                                                               (3, 'Люля Кебаб острый', 'LLKB', 'DFWR', CURRENT_TIMESTAMP);

-- Ингредиенты для первого донера (Классический с бараниной)
INSERT INTO DONER_INGREDIENTS (DONER_ID, INGREDIENTS_ID) VALUES
                                                             (1, 'HLPN'),  -- Халапеньо
                                                             (1, 'CHES'),  -- Сыр
                                                             (1, 'PTAT'),  -- Картошка фри
                                                             (1, 'SALD'),  -- Летний салат
                                                             (1, 'BMSC');  -- Биг Мак соус

-- Ингредиенты для второго донера (Сырный с курицей)
INSERT INTO DONER_INGREDIENTS (DONER_ID, INGREDIENTS_ID) VALUES
                                                             (2, 'CHES'),  -- Сыр
                                                             (2, 'PTAT'),  -- Картошка фри
                                                             (2, 'SALD'),  -- Летний салат
                                                             (2, 'BTSC');  -- Биг Тейсти соус

-- Ингредиенты для третьего донера (Люля Кебаб острый)
INSERT INTO DONER_INGREDIENTS (DONER_ID, INGREDIENTS_ID) VALUES
                                                             (3, 'HLPN'),  -- Халапеньо
                                                             (3, 'CHES'),  -- Сыр
                                                             (3, 'PTAT'),  -- Картошка фри
                                                             (3, 'BMSC');  -- Биг Мак соус

