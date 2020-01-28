CREATE TABLE IF NOT EXISTS cookie_orders (
    id SERIAL PRIMARY KEY,
    lastName TEXT NOT NULL,
    address TEXT NOT NULL,
    phoneOrEmail TEXT NOT NULL,
    numberDonated INTEGER NOT NULL DEFAULT 0 CHECK (numberDonated >= 0),
    numberThanksALot INTEGER NOT NULL DEFAULT 0 CHECK (numberThanksALot >= 0),
    numberSmores INTEGER NOT NULL DEFAULT 0 CHECK (numberSmores >= 0),
    numberLemonades INTEGER NOT NULL DEFAULT 0 CHECK (numberLemonades >= 0),
    numberShortbreads INTEGER NOT NULL DEFAULT 0 CHECK (numberShortbreads >= 0),
    numberThinMints INTEGER NOT NULL DEFAULT 0 CHECK (numberThinMints >= 0),
    numberPeanutButterPatties INTEGER NOT NULL DEFAULT 0 CHECK (numberPeanutButterPatties >= 0),
    numberCaramelDeLites INTEGER NOT NULL DEFAULT 0 CHECK (numberCaramelDeLites >= 0),
    numberPeanutButterSandwich INTEGER NOT NULL DEFAULT 0 CHECK (numberPeanutButterSandwich >= 0),
    paid BOOLEAN DEFAULT FALSE
);