SELECT * FROM activity LEFT JOIN activity_classroom ac on activity.activity_id = ac.activity_id
WHERE classroom_id = (SELECT class_room_id FROM classroom WHERE class_qr = '5fda8d55-9f94-4df1-b80f-61962b3d52b4') AND NOW() < activity.start ORDER BY activity.start ASC
