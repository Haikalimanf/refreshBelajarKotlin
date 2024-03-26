import java.util.*

class Mahasiswa(
    private val nama: String,
    private val nim: Int,
    private val alamat: String,
    private val email: String,
    private val noHp: Int
) {
    fun getNama(): String {
        return nama
    }

    fun getNim(): Int {
        return nim
    }

    fun getAlamat(): String {
        return alamat
    }

    fun getEmail(): String {
        return email
    }

    fun getNoHp(): Int {
        return noHp
    }
}

class DatabaseMahasiswa {
    private val pelajar: ArrayList<Mahasiswa> = ArrayList()

    fun tambahMahasiswa(mahasiswa: Mahasiswa) {
        pelajar.add(mahasiswa)
    }

    fun getDaftarMahasiswa(): ArrayList<Mahasiswa> {
        return pelajar
    }

    fun getTotalMahasiswa(): Int {
        return pelajar.size
    }
}

fun main() {
    val database = DatabaseMahasiswa()
    val scanner = Scanner(System.`in`)
    var berjalan = true
    while (berjalan) {
        println("---------------------------------------------")
        println("Selamat datang di program Data Mahasiswa Universitas Raden Charles II")
        println("Menu:")
        println("1. Tambah Data Mahasiswa")
        println("2. Tampilkan Data Mahasiswa")
        println("3. Keluar")
        print("Pilih menu: ")
        val pilihan = scanner.nextInt()
        scanner.nextLine()
        when (pilihan) {
            1 -> tambahDataMahasiswa(database, scanner)
            2 -> tampilkanDataMahasiswa(database)
            3 -> {
                berjalan = false
                println("Program sudah berakhir.")
            }
            else -> println("Menu tidak Ada.")
        }
    }
}

fun tambahDataMahasiswa(database: DatabaseMahasiswa, scanner: Scanner) {
    println("Input data mahasiswa:")
    print("Nama: ")
    val nama = scanner.nextLine()
    print("NIM: ")
    val nim = scanner.nextInt()
    scanner.nextLine()
    print("Alamat: ")
    val alamat = scanner.nextLine()
    print("Email: ")
    val email = scanner.nextLine()
    print("No HP: ")
    val noHp = scanner.nextInt()
    scanner.nextLine()

    val mahasiswa = Mahasiswa(nama, nim, alamat, email, noHp)
    database.tambahMahasiswa(mahasiswa)
    println("Data mahasiswa berhasil ditambahkan.")
}

fun tampilkanDataMahasiswa(database: DatabaseMahasiswa) {
    val daftarMahasiswa = database.getDaftarMahasiswa()
    println("\nDaftar Mahasiswa:")
    if (daftarMahasiswa.isEmpty()) {
        println("Belum ada data mahasiswa.")
        println("")
    } else {
        println("Daftar Mahasiswa:")
        for (mahasiswa in daftarMahasiswa) {
            println("Nama: ${mahasiswa.getNama()}")
            println("NIM: ${mahasiswa.getNim()}")
            println("Alamat: ${mahasiswa.getAlamat()}")
            println("Email: ${mahasiswa.getEmail()}")
            println("No HP: ${mahasiswa.getNoHp()}")
            println()
        }
    }
}
