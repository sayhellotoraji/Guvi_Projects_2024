
SHOW SCHEMAS;

# Execute the command to shift the current database
USE Bus_Ticket_Booking;

# Passenger Info Table
CREATE TABLE passenger (
    passenger_id INT NOT NULL AUTO_INCREMENT,
    passenger_name VARCHAR(24) NOT NULL,
    email VARCHAR(36) NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    login_password VARCHAR(24) NOT NULL,
    PRIMARY KEY(passenger_id)
);

INSERT INTO passenger(passenger_name, email, mobile_no, login_password) 
VALUES
('Rajasekar T', 'raj@outlook.com', '9999999999', 'JFSWD2'),
('Mohan', 'mohan@gmail.com', '6666666666', 'Agri');

SELECT * FROM passenger;


#-----------------------------------------------------------------

# Bus Info - Table

CREATE TABLE bus ( 
    bus_id INT NOT NULL AUTO_INCREMENT,
    bus_name VARCHAR(24) NOT NULL,
    from_loc VARCHAR(24), 
    to_loc VARCHAR(24),
    start_date DATE,
    end_date DATE,
    start_time TIME,
    end_time TIME,
    route VARCHAR(24),
    total_seats INT,
    available_seats INT,
    price INT,
    PRIMARY KEY(bus_id)
);

INSERT INTO bus(bus_name, from_loc, to_loc, start_date, end_date, start_time, end_time, route, total_seats, available_seats, price) 
values
('Mahalakshmi', 'Vellore', 'Chennai', '2024-02-24', '2024-02-24', '07:00:00','10:30:00','Kanchipuram',100, 100, 350),
('Sita', 'Vellore', 'Chennai', '2024-02-24', '2024-02-24', '10:00:00','02:00:00','Kanchipuram',120, 120, 400),
('Ramajayam', 'Tiruvannamalai', 'Pondicherry', '2024-02-25', '2024-02-25', '10:00:00','02:30:00','Tindivanam',120, 120, 500),
('Kannagi', 'Polur', 'Vellore', '2024-02-26', '2024-02-26', '07:00:00','08:30:00','Santhavasal',100, 100, 350);



SELECT * FROM bus;

#-----------------------------------------------------------------

# Booking - Table

CREATE TABLE booking (
    booking_id INT NOT NULL AUTO_INCREMENT,
    passenger_id INT,
    passenger_name VARCHAR(24),
    bus_id INT,
    bus_name VARCHAR(24),
    seat_qty INT,
    booked_price INT,
    amount INT,
    booked_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (booking_id),
    FOREIGN KEY (passenger_id)
        REFERENCES passenger (passenger_id),
    FOREIGN KEY (bus_id)
        REFERENCES bus (bus_id)
);

INSERT INTO booking(passenger_id, passenger_name, bus_id, bus_name, seat_qty, booked_price, amount)
VALUES(1, 'Rajasekar T', 1, 'Mahalakshmi', 5, 350, 1750);

SELECT * FROM booking;
