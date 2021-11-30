package mx.tecm.tepic.ladm_u2_p2_canvas_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Focos (act:MainActivity): View(act) {
    val principal = act

    //Imagenes
    val fantasma = BitmapFactory.decodeResource(principal.resources,R.drawable.velita)
    val apagado = BitmapFactory.decodeResource(principal.resources,R.drawable.apagado)
    val encendido = BitmapFactory.decodeResource(principal.resources,R.drawable.encendido)
    val encendido_color = BitmapFactory.decodeResource(principal.resources,R.drawable.encendidoazul)

    //variables de control
    var dia = false
    var fiesta = false

    //inicio de movimiento del fantasma
    var fantasmaX = 700f
    var mov = 20

    val movFantasma = object: CountDownTimer(2000,80){

        override fun onTick(p0: Long) {
            //lo que ejeccuta
            fantasmaX =  fantasmaX + mov
            invalidate()    //forzamos al ondraw a volver a pintarse

            if (fantasmaX < 0f || fantasmaX > 700f) {
                mov = -1 *mov
            }
        }

        override fun onFinish() {
            //aqui va el start que vuelve a ejecutar
            start()
        }
    }

    init{
        movFantasma.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        canvas.drawColor(Color.WHITE)

        //Focos apagados
        canvas.drawBitmap(apagado,20f,100f,paint)
        canvas.drawBitmap(apagado,360f,100f,paint)
        canvas.drawBitmap(apagado,700f,100f,paint)

        //Focos Encendidos
        if(dia == true) {
            canvas.drawBitmap(encendido,360f,100f,paint)
        }

        //Focos Encendidos de color azul
        if(fiesta == true) {
            canvas.drawBitmap(encendido_color,20f,100f,paint)
            canvas.drawBitmap(encendido_color,700f,100f,paint)
        }

        //Fantasma
        canvas.drawBitmap(fantasma,100f,1200f,paint)
    }
}