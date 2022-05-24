-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Apr 2022 pada 05.14
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_toko`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `KodeBarang` varchar(10) NOT NULL,
  `NamaBarang` varchar(30) NOT NULL,
  `HargaBeliBarang` int(11) NOT NULL,
  `HargaJualBarang` int(11) NOT NULL,
  `StokBarang` int(11) NOT NULL,
  `StokMinBarang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`KodeBarang`, `NamaBarang`, `HargaBeliBarang`, `HargaJualBarang`, `StokBarang`, `StokMinBarang`) VALUES
('B001', 'Bili', 9000, 9100, 9, 6),
('K001', 'Almari', 150000, 170000, 7, 5),
('K002', 'Fan', 200000, 220000, 10, 8);

-- --------------------------------------------------------

--
-- Struktur dari tabel `konsumen`
--

CREATE TABLE `konsumen` (
  `KodeKonsumen` varchar(10) NOT NULL,
  `NamaKonsumen` varchar(30) NOT NULL,
  `AlamatKonsumen` varchar(50) NOT NULL,
  `KotaKonsumen` varchar(20) NOT NULL,
  `TelpKonsumen` varchar(15) NOT NULL,
  `HPKonsumen` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `konsumen`
--

INSERT INTO `konsumen` (`KodeKonsumen`, `NamaKonsumen`, `AlamatKonsumen`, `KotaKonsumen`, `TelpKonsumen`, `HPKonsumen`) VALUES
('67768', 'Candra', 'Kp. Mawar', 'Solo', '0211291', '08912729111'),
('K001', 'Bagas', 'Jl. Anggrek', 'Bandung', '02177373', '0817272281'),
('k002', 'Yoga', 'Jl. Melati', 'Demak', '0217212', '08812621266'),
('K003', 'Ani', 'Jl. kakap', 'Semarang', '02133113', '0888181213');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `KodeSupplier` varchar(10) NOT NULL,
  `NamaSupplier` varchar(30) NOT NULL,
  `AlamatSupplier` varchar(50) NOT NULL,
  `KotaSupplier` varchar(20) NOT NULL,
  `TelpSupplier` varchar(15) NOT NULL,
  `HPSupplier` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`KodeSupplier`, `NamaSupplier`, `AlamatSupplier`, `KotaSupplier`, `TelpSupplier`, `HPSupplier`) VALUES
('S001', 'Endang', 'Jl. Kejora', 'Solo', '081378', '089131836138'),
('S002', 'Siti', 'Jl. Mawar', 'Solo', '080144', '0881313313');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`KodeBarang`);

--
-- Indeks untuk tabel `konsumen`
--
ALTER TABLE `konsumen`
  ADD PRIMARY KEY (`KodeKonsumen`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`KodeSupplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
