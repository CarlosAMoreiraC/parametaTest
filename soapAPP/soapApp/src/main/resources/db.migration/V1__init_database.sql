CREATE TABLE employee (
  names VARCHAR(50) not null PRIMARY KEY,
  last_names VARCHAR(200) not null,
  document_type VARCHAR(2) not null,
  document_number VARCHAR(20) not null,
  birth_date date not null,
  vinculation_date date not null,
  role VARCHAR(20) not null,
  salary double precision not null
);