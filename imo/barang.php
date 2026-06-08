<?php
require_once 'config.php';
setHeaders();

$method = $_SERVER['REQUEST_METHOD'];
$id = isset($_GET['id']) ? (int) $_GET['id'] : null;

switch ($method) {
    case 'GET':
        $conn = getConnection();
        if ($id) {
            $stmt = $conn->prepare('SELECT * FROM barang WHERE id = ?');
            $stmt->bind_param('i', $id);
            $stmt->execute();
            $result = $stmt->get_result();
            $barang = $result->fetch_assoc();
            if ($barang)
                successResponse($barang);
            else
                errorResponse('Barang tidak ditemukan', 404);
        } else {
            $result = $conn->query('SELECT * FROM barang ORDER BY nama_barang ASC');
            $barang = $result->fetch_all(MYSQLI_ASSOC);
            successResponse($barang);
        }
        $conn->close();
        break;

    default:
        errorResponse('Method tidak diizinkan', 405);
}