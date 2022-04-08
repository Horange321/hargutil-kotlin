package hora

class Hargs constructor(argv: String) {
    private val argv = argv
    private val ys = HashMap<String, Array<String>>()

    val ver = "Kotlin v1.1.3"

    /**
     * Add  map.
     * 添加映射
     * @param s short 短参数
     * @param l long 长参数
     * @param m map 映射
     */
    fun add(s: String, l: String, n: String): Hargs {
        if (n.isEmpty()) {
            throw IllegalArgumentException("n can't be empty.")
        }
        if (s.isEmpty() && l.isEmpty()) {
            throw IllegalArgumentException("s & l can't be empty at the same time")
        }
        ys[n] = arrayOf(s, l)
        return this
    }

    /**
     * Whether the beginning of x is y.
     */
    private fun startWith(x: String, y: String): Boolean {
        if (x.length < y.length) return false
        for (i in 0 until y.length) {
            if (x[i] != y[i]) return false
        }
        return true
    }

    fun toMap(): Map<String, String?> {
        val r = HashMap<String, String?>()
        val ags = argv.split(" ")

        for (i in ys.keys) {
            r[i] = null
            for (j in ags) {
                val i1 = ("-" + ys[i]!![0] + "=")
                val i2 = ("--" + ys[i]!![1] + "=")
                val jj = if (j[j.length - 1] == '=') j else j + "="

                if (startWith(jj, i1) or startWith(jj, i2)) {
                    r[i] = jj.split("=")[1]
                    break
                }
            }
        }
        return r
    }
}