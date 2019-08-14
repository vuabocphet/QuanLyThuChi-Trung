package com.example.quanlythuchi.model;

public class Note {
    private String noteId;
    private String noteTitle;
    private Double noteContent;

    public Note(String noteId, String noteTitle, Double noteContent) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public Note(String noteTitle, Double noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public Note() {

    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public Double getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(Double noteContent) {
        this.noteContent = noteContent;
    }
}
