# Dumping database structure for spring_bank_app_db
DROP DATABASE IF EXISTS `common`;
CREATE DATABASE IF NOT EXISTS `common`
/*!40100 DEFAULT CHARACTER SET latin1 */;
USE `common`;
# Dumping structure for table common.bank_account_details
DROP TABLE IF EXISTS `bank_account_details`;
CREATE TABLE IF NOT EXISTS `bank_account_details` (
  `ACCOUNT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `BALANCE_AMOUNT` float NOT NULL,
  `LAST_TRANSACTION_TS` datetime NOT NULL,
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 COMMENT = 'Contains information about bank accounts of customers';
# Dumping structure for table common.fixed_deposit_details
DROP TABLE IF EXISTS `fixed_deposit_details`;
CREATE TABLE IF NOT EXISTS `fixed_deposit_details` (
  `FIXED_DEPOSIT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` int(10) NOT NULL,
  `FD_CREATION_DATE` date NOT NULL,
  `AMOUNT` int(10) NOT NULL,
  `TENURE` int(10) NOT NULL,
  `ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`FIXED_DEPOSIT_ID`),
  KEY `FK_fixed_deposit_details_bank_account_details` (`ACCOUNT_ID`),
  CONSTRAINT `FK_fixed_deposit_details_bank_account_details` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `bank_account_details` (`ACCOUNT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = latin1;