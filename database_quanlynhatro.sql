-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 12, 2017 at 06:10 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `database_quanlynhatro`
--

-- --------------------------------------------------------

--
-- Table structure for table `dangnhap`
--

CREATE TABLE IF NOT EXISTS `dangnhap` (
  `TenTaiKhoan` varchar(100) CHARACTER SET utf8 NOT NULL,
  `MatKhau` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `dangnhap`
--

INSERT INTO `dangnhap` (`TenTaiKhoan`, `MatKhau`) VALUES
('Admin', '123'),
('Admin2', '123');

-- --------------------------------------------------------

--
-- Table structure for table `dichvu`
--

CREATE TABLE IF NOT EXISTS `dichvu` (
  `MaDV` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenDV` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `dichvu`
--

INSERT INTO `dichvu` (`MaDV`, `TenDV`) VALUES
('DV01', 'Điện'),
('DV02', 'Nước');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE IF NOT EXISTS `hoadon` (
  `MaHD` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaPTT` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayLapHD` date NOT NULL,
  `ThueVAT` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE IF NOT EXISTS `khachhang` (
  `MaKH` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenKH` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NamSinh` date NOT NULL,
  `CMND` int(11) NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `NgheNghiep` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `SDT` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieudangky`
--

CREATE TABLE IF NOT EXISTS `phieudangky` (
  `MaPDK` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaKH` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaPhong` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `NgayThue` date NOT NULL,
  `NgayTra` date NOT NULL,
  `TraTruoc` float DEFAULT NULL,
  `TraSau` float DEFAULT NULL,
  `ChuThich` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieuthanhtoan`
--

CREATE TABLE IF NOT EXISTS `phieuthanhtoan` (
  `MaPTT` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaPDK` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SoThang` int(11) DEFAULT NULL,
  `NgayTT` date NOT NULL,
  `TongTien` float DEFAULT NULL,
  `TienPhaiTra` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phongtro`
--

CREATE TABLE IF NOT EXISTS `phongtro` (
  `MaPhong` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `HienTrangPhong` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `GiaPhong` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `phongtro`
--

INSERT INTO `phongtro` (`MaPhong`, `HienTrangPhong`, `GiaPhong`) VALUES
('P01', 'Đang Sử dụng', 1200000);

-- --------------------------------------------------------

--
-- Table structure for table `sudung`
--

CREATE TABLE IF NOT EXISTS `sudung` (
  `MaDV` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  `MaKH` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  `NgaySD` date DEFAULT NULL,
  `GiaDV` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `thietbi`
--

CREATE TABLE IF NOT EXISTS `thietbi` (
  `MaTB` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenTB` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `thietbi`
--

INSERT INTO `thietbi` (`MaTB`, `TenTB`) VALUES
('TB01', 'TiVi'),
('TB02', 'Quạt');

-- --------------------------------------------------------

--
-- Table structure for table `trangbi`
--

CREATE TABLE IF NOT EXISTS `trangbi` (
  `MaPhong` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaTB` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `trangbi`
--

INSERT INTO `trangbi` (`MaPhong`, `MaTB`) VALUES
('P01', 'TB01'),
('P01', 'TB02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dangnhap`
--
ALTER TABLE `dangnhap`
 ADD PRIMARY KEY (`TenTaiKhoan`);

--
-- Indexes for table `dichvu`
--
ALTER TABLE `dichvu`
 ADD PRIMARY KEY (`MaDV`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
 ADD PRIMARY KEY (`MaHD`), ADD KEY `fk_HD_MaPTT` (`MaPTT`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
 ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `phieudangky`
--
ALTER TABLE `phieudangky`
 ADD PRIMARY KEY (`MaPDK`), ADD KEY `fk_PDK_MaKH` (`MaKH`), ADD KEY `fk_PDK_MaPhong` (`MaPhong`);

--
-- Indexes for table `phieuthanhtoan`
--
ALTER TABLE `phieuthanhtoan`
 ADD PRIMARY KEY (`MaPTT`), ADD KEY `fk_PTT_MaPDK` (`MaPDK`);

--
-- Indexes for table `phongtro`
--
ALTER TABLE `phongtro`
 ADD PRIMARY KEY (`MaPhong`);

--
-- Indexes for table `sudung`
--
ALTER TABLE `sudung`
 ADD PRIMARY KEY (`MaDV`,`MaKH`), ADD KEY `fk_SD_MaKH` (`MaKH`);

--
-- Indexes for table `thietbi`
--
ALTER TABLE `thietbi`
 ADD PRIMARY KEY (`MaTB`);

--
-- Indexes for table `trangbi`
--
ALTER TABLE `trangbi`
 ADD PRIMARY KEY (`MaPhong`,`MaTB`), ADD KEY `fk_TB_MaTB` (`MaTB`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
ADD CONSTRAINT `fk_HD_MaPTT` FOREIGN KEY (`MaPTT`) REFERENCES `phieuthanhtoan` (`MaPTT`);

--
-- Constraints for table `phieudangky`
--
ALTER TABLE `phieudangky`
ADD CONSTRAINT `fk_PDK_MaKH` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
ADD CONSTRAINT `fk_PDK_MaPhong` FOREIGN KEY (`MaPhong`) REFERENCES `trangbi` (`MaPhong`);

--
-- Constraints for table `phieuthanhtoan`
--
ALTER TABLE `phieuthanhtoan`
ADD CONSTRAINT `fk_PTT_MaPDK` FOREIGN KEY (`MaPDK`) REFERENCES `phieudangky` (`MaPDk`);

--
-- Constraints for table `sudung`
--
ALTER TABLE `sudung`
ADD CONSTRAINT `fk_SD_MaDV` FOREIGN KEY (`MaDV`) REFERENCES `dichvu` (`MaDV`),
ADD CONSTRAINT `fk_SD_MaKH` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`);

--
-- Constraints for table `trangbi`
--
ALTER TABLE `trangbi`
ADD CONSTRAINT `fk_TB_MaPhong` FOREIGN KEY (`MaPhong`) REFERENCES `phongtro` (`MaPhong`),
ADD CONSTRAINT `fk_TB_MaTB` FOREIGN KEY (`MaTB`) REFERENCES `thietbi` (`MaTB`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
