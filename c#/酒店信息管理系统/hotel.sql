USE [hotel]
GO
/****** Object:  Table [dbo].[check]    Script Date: 2022/12/29 20:12:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[check](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[room] [int] NULL,
	[guest_id] [int] NULL,
	[start_date] [nchar](15) NULL,
	[end_date] [nchar](15) NULL,
	[script] [nchar](20) NULL,
	[end_script] [nchar](20) NULL,
	[state] [int] NULL,
 CONSTRAINT [PK_check] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[guest]    Script Date: 2022/12/29 20:12:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[guest](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[number] [nchar](18) NULL,
	[name] [nchar](6) NULL,
	[sex] [nchar](2) NULL,
	[phone] [nchar](20) NULL,
 CONSTRAINT [PK_guest] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[room]    Script Date: 2022/12/29 20:12:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[number] [int] NULL,
	[price] [float] NULL,
	[phone] [nchar](20) NULL
) ON [PRIMARY]
GO
