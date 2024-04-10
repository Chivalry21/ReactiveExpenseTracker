CREATE TABLE IF NOT EXISTS users (
         id SERIAL PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         username VARCHAR(255) UNIQUE NOT NULL,
         password VARCHAR(255) NOT NULL,
         role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS categories (
      id SERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS expenses (
        id SERIAL PRIMARY KEY,
        item_name VARCHAR(255) NOT NULL,
        description TEXT,
        amount NUMERIC(19, 4) NOT NULL,
        date DATE NOT NULL,
        category_id INT NOT NULL,
        user_id INT,
        FOREIGN KEY (category_id) REFERENCES categories(id),
        FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE IF NOT EXISTS tokens (
      id SERIAL PRIMARY KEY,
      token VARCHAR(255) NOT NULL,
      is_revoked BOOLEAN,
      is_expired BOOLEAN,
      user_id BIGINT,
      FOREIGN KEY (user_id) REFERENCES users(id)
);


