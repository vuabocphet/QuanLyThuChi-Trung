package com.example.quanlythuchi.model;

public class Note4 {
    private String noteId4;
    private String noteTitle4;
    private Double noteContent4;

    public Note4(String noteId, String noteTitle, Double noteContent) {
        this.noteId4 = noteId;
        this.noteTitle4 = noteTitle;
        this.noteContent4 = noteContent;
    }

    public Note4(String noteTitle, Double noteContent) {
        this.noteTitle4 = noteTitle;
        this.noteContent4 = noteContent;
    }

    public Note4() {

    }

    public String getNoteId4() {
        return noteId4;
    }

    public void setNoteId4(String noteId4) {
        this.noteId4 = noteId4;
    }

    public String getNoteTitle4() {
        return noteTitle4;
    }

    public void setNoteTitle4(String noteTitle4) {
        this.noteTitle4 = noteTitle4;
    }

    public Double getNoteContent4() {
        return noteContent4;
    }

    public void setNoteContent4(Double noteContent4) {
        this.noteContent4 = noteContent4;
    }
}
