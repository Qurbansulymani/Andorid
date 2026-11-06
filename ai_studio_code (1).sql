CREATE TABLE IF NOT EXISTS `afghanistan_items` (
    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `titleFa` TEXT NOT NULL,
    `titleEn` TEXT NOT NULL,
    `category` TEXT NOT NULL,
    `provinceFa` TEXT NOT NULL,
    `provinceEn` TEXT NOT NULL,
    `descriptionFa` TEXT NOT NULL,
    `descriptionEn` TEXT NOT NULL,
    `highlightsFa` TEXT NOT NULL DEFAULT '',
    `highlightsEn` TEXT NOT NULL DEFAULT '',
    `imageResName` TEXT NOT NULL DEFAULT '',
    `imageUri` TEXT,
    `isUserAdded` INTEGER NOT NULL DEFAULT 0,
    `isFavorite` INTEGER NOT NULL DEFAULT 0,
    `createdAt` INTEGER NOT NULL
);