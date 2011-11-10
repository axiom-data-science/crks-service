package com.axiomalaska.crks.visitor;

import com.axiomalaska.crks.vo.DataLayer;
import com.axiomalaska.crks.vo.RasterLayer;
import com.axiomalaska.crks.vo.VectorLayer;

public class LayerVisitorAdapter implements LayerVisitor {
    public void visit( VectorLayer layer ){};
    public void visit( RasterLayer layer ){};
    public void visit( DataLayer layer ){};
}