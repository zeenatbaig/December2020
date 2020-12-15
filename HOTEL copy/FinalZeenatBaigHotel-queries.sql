-- 1. Write a query that returns a list of reservations that end in July 2023,
--  including the name of the guest, the room number(s), and the reservation dates.

USE hotel;
SELECT 
Guest.nameOfGuest,
Reservation.startDate,
Reservation.endDate,
Room_has_Reservation.Room_idRoom
FROM Reservation
INNER JOIN Guest ON Reservation.Guest_idGuest= Guest.idGuest
INNER JOIN Room_has_Reservation on Reservation.idReservation =Room_has_Reservation.Reservation_idReservation
WHERE YEAR(endDate) = 2023 AND MONTH(endDate) = 07;
-- 'Bettyann Seery','2023-07-28','2023-07-29','303'
-- 'Walter Holaway','2023-07-13','2023-07-14','204'
-- 'Your Name','2023-06-28','2023-07-02','205'



-- 2. Write a query that returns a list of all reservations for rooms with a jacuzzi,
 -- displaying the guest's name, the room number, and the dates of the reservation.
 
SELECT 
Guest.nameOfGuest,
Ameneties_has_Room.Room_idRoom,
Reservation.startDate,
Reservation.endDate
FROM Ameneties
INNER JOIN Ameneties_has_Room ON Ameneties.idAmeneties = Ameneties_has_Room.Ameneties_idAmeneties
INNER JOIN Room ON Ameneties_has_Room.Room_idRoom = Room.idRoom
INNER JOIN Room_has_Reservation ON Room.idRoom = Room_has_Reservation.Room_idRoom
INNER JOIN Reservation ON Room_has_Reservation.Reservation_idReservation = Reservation.idReservation
INNER JOIN Guest ON Reservation.Guest_idGuest = Guest.idGuest
WHERE Ameneties.amenetyType = 'jacuzzi';
-- 'Karie Yang','2023-07-28','2023-07-29','303'
-- 'Bettyann Seery','2023-07-13','2023-07-14','204'
-- 'Walter Holaway','2023-06-28','2023-07-02','205'
-- 'Bettyann Seery','2023-06-28','2023-07-02','205'

-- 4. Write a query that returns all the rooms reserved for a specific guest, including the guest's name,
--  the room(s) reserved, the starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the existing data.)

SELECT 
Room.idRoom,
Reservation.adult +Reservation.children,
Reservation.startDate,
Reservation.endDate
FROM Guest
INNER JOIN Reservation ON Guest.idGuest= Reservation.Guest_idGuest
INNER JOIN Room_has_Reservation ON Reservation.idReservation =Room_has_Reservation.Reservation_idReservation
INNER JOIN Room ON Room_has_Reservation.Reservation_idReservation = Room.idRoom
WHERE nameOfGuest = 'Karie Yang';
-- '201','4','2023-03-06','2023-07-03',

-- 4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. 
-- The results should include all rooms, whether or not there is a reservation associated with the room.

SELECT
Room.idRoom,
Reservation.idReservation,
Reservation.totalPrice,
Room.basePrice
FROM Room_has_Reservation
INNER JOIN Reservation ON Reservation.idReservation = Room_has_Reservation.Reservation_idReservation
INNER JOIN Room ON Room_has_Reservation.Room_idRoom =Room.idRoom
WHERE Room.idRoom !=  'null';
-- '201','1','299.98','199.99'
-- '203','1','299.98','199.99'
-- '205','1','299.98','174.99'
-- '206','1','299.98','149.99'
-- '207','1','299.98','174.99'
-- '208','1','299.98','149.99'
-- '301','1','299.98','199.99'
-- '303','1','299.98','199.99'
-- '305','1','299.98','174.99'
-- '306','1','299.98','149.99'
-- '307','1','299.98','174.99'
-- '308','1','299.98','149.99'
-- '401','1','299.98','399.99'
-- '402','1','299.98','399.99'
-- '201','2','999.95','199.99'
-- '203','2','999.95','199.99'
-- '205','2','999.95','174.99'
-- '207','2','999.95','174.99'
-- '301','2','999.95','199.99'
-- '303','2','999.95','199.99'
-- '305','2','999.95','174.99'
-- '307','2','999.95','174.99'
-- '202','3','349.98','174.99'
-- '204','3','349.98','174.99'
-- '205','3','349.98','174.99'
-- '206','3','349.98','149.99'
-- '207','3','349.98','174.99'
-- '208','3','349.98','149.99'
-- '302','3','349.98','174.99'
-- '304','3','349.98','174.99'
-- '305','3','349.98','174.99'
-- '306','3','349.98','149.99'
-- '307','3','349.98','174.99'
-- '308','3','349.98','149.99'
-- '401','3','349.98','399.99'
-- '402','3','349.98','399.99'
-- '201','4','199.99','199.99'
-- '401','4','199.99','399.99'
-- '402','4','199.99','399.99'
-- '307','5','524.97','174.99'
-- '302','6','924.95','174.99'
-- '202','7','349.98','174.99'
-- '301','9','799.96','199.99'
-- '207','10','174.99','174.99'
-- '206','12','599.96','149.99'
-- '208','13','599.96','149.99'
-- '304','14','184.99','174.99'
-- '205','15','699.96','174.99'
-- '204','16','184.99','174.99'
-- '303','18','199.99','199.99'
-- '305','19','349.98','174.99'
-- '208','20','149.99','149.99'
-- '203','21','399.98','199.99'
-- '206','23','449.97','149.99'
-- '301','24','599.97','199.99'
-- '302','25','699.96','174.99'

-- 5  Write a query that returns all rooms with a capacity of three or more 
-- and that are reserved on any date in April 2023.


SELECT
Room.idRoom
From Reservation
INNER JOIN Room_has_Reservation ON Reservation.idReservation =Room_has_Reservation.Reservation_idReservation
INNER JOIN Room ON Room_has_Reservation.Room_idRoom = Room.idRoom
WHERE (Room.RoomType_idRoomType = '2' OR '3') AND YEAR(Reservation.endDate) = 2023 AND MONTH(Reservation.endDate) = 04;
 -- '301''207'

-- 6. Write a query that returns a list of all guest names and the number of reservations
-- per guest, sorted starting with the guest with the most reservations and 
-- then by the guest's last name.
SELECT
Guest.nameOfGuest
FROM Guest
INNER JOIN Reservation ON Guest.idGuest = Reservation.Guest_idGuest
ORDER BY Reservation.idReservation, Guest.nameOfGuest;
-- 'Mack Simmer'
-- 'Bettyann Seery'
-- 'Duane Cullison'
-- 'Karie Yang'
-- 'Your Name'
-- 'Aurore Lipton'
-- 'Zachery Luechtefeld'
-- 'Walter Holaway'
-- 'Wilfred Vise'
-- 'Joleen Tison'
-- 'Joleen Tison'
-- 'Aurore Lipton'
-- 'Your Name'
-- 'Walter Holaway'
-- 'Bettyann Seery'
-- 'Bettyann Seery'
-- 'Mack Simmer'
-- 'Karie Yang'
-- 'Mack Simmer'
-- 'Mack Simmer'
-- 'Maritza Tilton'

-- 7Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)
-- 7Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)
SELECT
Guest.nameOfGuest,
Guest.address,
Guest.phoneNumber
FROM Guest
ORDER BY phoneNumber;
-- 'Karie Yang','9378 W. Augusta Ave.','(214) 730-0298'
-- 'Joleen Tison','87 Queen St.','(231) 893-2755'
-- 'Mack Simmer','379 Old Shore Street','(291) 553-0508'
-- 'Duane Cullison','9662 Foxrun Lane','(308) 494-0198'
-- 'Your Name','12 40th Street','(324)876-8765'
-- 'Aurore Lipton','762 Wild Rose Street','(377) 507-0974'
-- 'Maritza Tilton','939 Linda Rd.','(446) 351-6860'
-- 'Walter Holaway','7556 Arrowhead St.','(446) 396-6785'
-- 'Bettyann Seery','750 Wintergreen Dr.','(478) 277-9632'
-- 'Zachery Luechtefeld','7 Poplar Dr.','(814) 485-2615'
-- 'Wilfred Vise','77 West Surrey Street','(834) 727-1001'
