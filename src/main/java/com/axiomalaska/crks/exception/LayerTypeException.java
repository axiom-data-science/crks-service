package com.axiomalaska.crks.exception;

import com.axiomalaska.crks.vo.Layer;

public class LayerTypeException extends Exception {
    public LayerTypeException( Layer layer ){
        super("Layer " + layer.getLabel() + " did not resolve to a layer type");
    }
}
