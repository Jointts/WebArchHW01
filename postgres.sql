CREATE TABLE poetry
(
    title VARCHAR(50),
    content VARCHAR(2500),
    year SMALLINT,
    id INTEGER PRIMARY KEY NOT NULL
);

INSERT INTO public.poetry (title, content, year, id) VALUES ('Invictus', 'TESTSETEST', 2004, 1);
INSERT INTO public.poetry (title, content, year, id) VALUES ('All the world''s a stage', 'All the world''s a stage,
And all the men and women merely players;
They have their exits and their entrances,
And one man in his time plays many parts,
His acts being seven ages. At first, the infant,
Mewling and puking in the nurse''s arms.
Then the whining schoolboy, with his satchel
And shining morning face, creeping like snail
Unwillingly to school. And then the lover,
Sighing like furnace, with a woeful ballad
Made to his mistress'' eyebrow. Then a soldier,
Full of strange oaths and bearded like the pard,
Jealous in honor, sudden and quick in quarrel,
Seeking the bubble reputation
Even in the cannon''s mouth. And then the justice,
In fair round belly with good capon lined,
With eyes severe and beard of formal cut,
Full of wise saws and modern instances;
And so he plays his part. The sixth age shifts
Into the lean and slippered pantaloon,
With spectacles on nose and pouch on side;
His youthful hose, well saved, a world too wide
For his shrunk shank, and his big manly voice,
Turning again toward childish treble, pipes
And whistles in his sound. Last scene of all,
That ends this strange eventful history,
Is second childishness and mere oblivion,
Sans teeth, sans eyes, sans taste, sans everything. ', 1632, 2);
INSERT INTO public.poetry (title, content, year, id) VALUES ('Shall I Compare Thee To A Summer''s Day?', 'Shall I compare thee to a summer''s day?
Thou art more lovely and more temperate.
Rough winds do shake the darling buds of May,
And summer''s lease hath all too short a date.
Sometime too hot the eye of heaven shines,
And often is his gold complexion dimmed;
And every fair from fair sometime declines,
By chance, or nature''s changing course, untrimmed;
But thy eternal summer shall not fade,
Nor lose possession of that fair thou ow''st,
Nor shall death brag thou wand''rest in his shade,
When in eternal lines to Time thou grow''st.
So long as men can breathe, or eyes can see,
So long lives this, and this gives life to thee. ', 1633, 3);
