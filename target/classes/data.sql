insert into coding_language (
    ID, CODING_NAME, DESCRIPTION
)
values(
    1,'C#','C# very similar to java and not hard to learn'
);

insert into coding_language (
    ID, CODING_NAME, DESCRIPTION
)
values(
    2,'Java','Java very similar to C# and not hard to learn'
);

insert into framework_engine(
    ID, name, quote, popularity, PAID_FOR_STUDENTS
)
values(
    1, 'Unity', 'Gamedevelopment',8,false
);

insert into framework_engine(
    ID, name, quote, popularity
)
values(
    2, 'Spring', 'WebApp development', 10
);

insert into framework_engine_languages(
    framework_engines_ID, LANGUAGES_ID
)values( 1, 1)


