-- ۱. دریافت تمام اطلاعات
SELECT * FROM afghanistan_items ORDER BY id ASC;

-- ۲. فیلتر کردن بر اساس دسته‌بندی (ولایات، پارک‌ها، غذاها، رسوم)
SELECT * FROM afghanistan_items WHERE category = :category ORDER BY id ASC;

-- ۳. جستجوی پیشرفته متنی در عنوان، ولایت یا متن توضیحات
SELECT * FROM afghanistan_items 
WHERE titleFa LIKE '%' || :query || '%' 
   OR titleEn LIKE '%' || :query || '%' 
   OR provinceFa LIKE '%' || :query || '%' 
   OR descriptionFa LIKE '%' || :query || '%'
ORDER BY id ASC;

-- ۴. مشاهده مطالبی که کاربر با فرم اضافه کرده است
SELECT * FROM afghanistan_items WHERE isUserAdded = 1 ORDER BY createdAt DESC;

-- ۵. تغییر وضعیت نشانه‌گذاری (Favorite)
UPDATE afghanistan_items SET isFavorite = :isFavorite WHERE id = :id;

-- ۶. حذف یک سطر از جدول
DELETE FROM afghanistan_items WHERE id = :id;