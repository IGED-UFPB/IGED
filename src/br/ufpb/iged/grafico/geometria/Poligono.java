package br.ufpb.iged.grafico.geometria;

import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.grafico.manager.PoligonoGrafico;
import java.awt.geom.Point2D;
import java.awt.Color;

public class Poligono extends PoligonoGrafico {

    //Adiciona um vertice do poligono
    public void add(Point2D p) {
        this.points.add(p);
    }

    public void mover(double dx, double dy) {
        for (Point2D p : points) {
            p.setLocation(p.getX() + dx, p.getY() + dy);
        }
    }

    public void evidencia(final Color cor, final float st, final Quadro quadro) {
        final Poligono p = this;
        //new Thread() {

            //public void run() {
                Color caux = p.getStrokeColor();
                float staux = p.getStroke();
                p.setStrokeColor(cor);
                p.setStroke(st);
                quadro.atualizar();

                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                }

                p.setStrokeColor(caux);
                p.setStroke(staux);
                quadro.atualizar();

            //}
        //}.start();
    }

    public void zoom(double z) {
        if (z < 0) {
            return;
        }

        Point2D pbase = points.get(0);

        for (int i = 1; i < points.size(); ++i) {
            Point2D p = points.get(i);
            double dx = 0;
            double dy = 0;
            if (pbase.getX() != p.getX()) {
                dx = (p.getX() - pbase.getX()) * z;
            }
            if (pbase.getY() != p.getY()) {
                dy = (p.getY() - pbase.getY()) * z;
            }
            p.setLocation(p.getX() + dx, p.getY() + dy);
        }
    }
}